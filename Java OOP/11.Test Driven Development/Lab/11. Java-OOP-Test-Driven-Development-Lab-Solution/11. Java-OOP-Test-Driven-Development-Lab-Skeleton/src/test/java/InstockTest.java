import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InstockTest {
    private Instock instock;
    private List<Product> testProducts;
    private final double LOWEST_PRICE = 9.0;

    @Before
    public void setUp() {
        instock = new Instock();
        testProducts = new ArrayList<>();
        testProducts.add(new Product("Ice cream", 10.0, 5));
        testProducts.add(new Product("Choco pie", 15.0, 3));
        testProducts.add(new Product("Sprite", 20.0, 8));
    }

    @Test
    public void testGetCountInitiallyZero() {
        Assert.assertEquals(0, instock.getCount());
    }

    @Test
    public void testAddProductIncreasesCount() {
        instock.add(testProducts.get(0));
        Assert.assertEquals(1, instock.getCount());
    }

    @Test
    public void testContainsProduct() {
        instock.add(testProducts.get(0));
        Assert.assertTrue(instock.contains(testProducts.get(0)));
    }

    @Test
    public void testContainsNonExistentProduct() {
        Assert.assertFalse(instock.contains(testProducts.get(0)));
    }

    @Test
    public void testChangeQuantity() {
        instock.add(testProducts.get(0));
        instock.changeQuantity("Ice cream", 3);
        Assert.assertEquals(8, instock.findByLabel("Ice cream").getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityNonExistentProduct() {
        instock.changeQuantity("NonExistent", 3);
    }

    @Test
    public void testFindValidIndex() {
        instock.add(testProducts.get(0));
        Assert.assertEquals(testProducts.get(0), instock.find(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindInvalidIndexThrowsException() {
        instock.find(0);
    }

    @Test
    public void testFindByLabel() {
        instock.add(testProducts.get(0));
        Assert.assertEquals(testProducts.get(0), instock.findByLabel("Ice cream"));
    }

    @Test
    public void testFindFirstByAlphabeticalOrder() {
        for (Product product : testProducts) {
            instock.add(product);
        }

        List<Product> expected = testProducts.stream()
                .sorted((p1, p2) -> p1.getLabel().compareTo(p2.getLabel()))
                .limit(2).collect(Collectors.toList());

        List<Product> result = (List<Product>) instock.findFirstByAlphabeticalOrder(2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testFindAllInRange() {
        for (Product product : testProducts) {
            instock.add(product);
        }

        List<Product> expected = testProducts.stream()
                .filter(product -> product.getPrice() > LOWEST_PRICE && product.getPrice() <= 20.0)
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice())).collect(Collectors.toList());

        List<Product> result = (List<Product>) instock.findAllInRange(LOWEST_PRICE, 20.0);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testFindAllByPrice() {
        for (Product product : testProducts) {
            instock.add(product);
        }

        List<Product> expected = testProducts.stream()
                .filter(product -> product.getPrice() == 15.0).collect(Collectors.toList());

        List<Product> result = (List<Product>) instock.findAllByPrice(15.0);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testFindFirstMostExpensiveProducts() {
        for (Product product : testProducts) {
            instock.add(product);
        }

        List<Product> expected = testProducts.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .limit(2).collect(Collectors.toList());

        List<Product> result = (List<Product>) instock.findFirstMostExpensiveProducts(2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testFindAllByQuantity() {
        for (Product product : testProducts) {
            instock.add(product);
        }

        List<Product> expected = testProducts.stream()
                .filter(product -> product.getQuantity() == 8).collect(Collectors.toList());

        List<Product> result = (List<Product>) instock.findAllByQuantity(8);
        Assert.assertEquals(expected, result);
    }
}
