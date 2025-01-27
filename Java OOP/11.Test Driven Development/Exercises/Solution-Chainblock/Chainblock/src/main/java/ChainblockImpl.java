import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new HashMap<>();
    }

    @Override
    public int getCount() {
        return transactions.size();
    }

    @Override
    public void add(Transaction transaction) {
        if (!transactions.containsKey(transaction.getId())) {
            transactions.put(transaction.getId(), transaction);
        }
    }

    @Override
    public boolean contains(Transaction transaction) {
        return transactions.containsKey(transaction.getId());
    }

    @Override
    public boolean contains(int id) {
        return transactions.containsKey(id);
    }

    @Override
    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        transactions.get(id).setStatus(newStatus);
    }

    @Override
    public void removeTransactionById(int id) {
        if (!transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        transactions.remove(id);
    }

    @Override
    public Transaction getById(int id) {
        if (!transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        return transactions.get(id);
    }

    @Override
    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        Iterable<Transaction> transactionIterable = transactions.values().stream()
                .filter(transaction -> transaction.getStatus() == status)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        if (countIterable(transactionIterable) > 0)
            return transactionIterable;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        return transactions.values().stream()
                .filter(transaction -> transaction.getStatus() == status)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return transactions.values().stream()
                .filter(transaction -> transaction.getStatus() == status)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactions.values().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return transactions.values().stream()
                .filter(transaction -> transaction.getFrom().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return transactions.values().stream()
                .filter(transaction -> transaction.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return transactions.values().stream()
                .filter(transaction -> transaction.getStatus() == status && transaction.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return transactions.values().stream()
                .filter(transaction -> transaction.getFrom().equals(sender) && transaction.getAmount() > amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return transactions.values().stream()
                .filter(transaction -> transaction.getTo().equals(receiver)
                        && transaction.getAmount() >= lo && transaction.getAmount() < hi)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return transactions.values().stream()
                .filter(transaction -> transaction.getAmount() >= lo && transaction.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Transaction> iterator() {
        return transactions.values().iterator();
    }

    private static <T> int countIterable(Iterable<T> iterable) {
        int count = 0;
        for (T item : iterable) {
            count++;
        }
        return count;
    }
}
