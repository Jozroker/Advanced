package lesson14.lesson;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Application {

    private static int cartCounter = 1;
    private static int itemCounter = 1;

    public static void main(String[] args) {
//        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        ItemRepository ir = new ItemRepository(sf);
//        CartRepository cr = new CartRepository(sf, ir);
//        Item item1 = new Item(2);
//        Item item2 = new Item(3);
//        Set<Item> items = new HashSet<>();
//        items.add(item1);
//        items.add(item2);
//        Cart cart = new Cart(50, "cart", items);
////        Cart cart = new Cart(1L, 50, "cart");
//        cr.save(cart);

        SessionFactory sf = SessionFactoryCreator.getInstance();
        ItemRepository ir = new ItemRepository(sf);
        CartRepository cr = new CartRepository(sf);
         Item itemWithNullCarts = createItem();
         Item itemInCart1 = createItem();
         Item itemInCart2 = createItem();
         Item itemInCart3 = createItem();
         Item itemInCart4 = createItem();
         Set<Item> items = new HashSet<>();
         items.add(itemInCart1);
         items.add(itemInCart2);
         items.add(itemInCart3);
         items.add(itemInCart4);
         Item itemWithManyCarts = createItem();

        Cart cartWithNullItems = createCart();
        Cart cartInItem1 = createCart();
        Cart cartInItem2 = createCart();
        Cart cartInItem3 = createCart();
        Cart cartInItem4 = createCart();
        Set<Cart> carts = new HashSet<>();
        carts.add(cartInItem1);
        carts.add(cartInItem2);
        carts.add(cartInItem3);
        carts.add(cartInItem4);
        Cart cartWithManyItems = createCart();

        cartWithManyItems.setItems(items);
        itemWithManyCarts.setCarts(carts);

        cr.save(cartWithNullItems);
        cr.save(cartWithManyItems);
        ir.save(itemWithNullCarts);
        ir.save(itemWithManyCarts);


    }

    private static Cart createCart() {
        Cart cart = new Cart();
        cart.setName("Cart" + cartCounter);
        cart.setTotal(cartCounter++);
        return cart;
    }

    private static Item createItem() {
        Item item = new Item();
        item.setTotal(itemCounter++);
        return item;
    }
}
