package itp341.exercises.week9_list_singleton.app.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

//TODO complete
public class CoffeeShopSingleton {

    //TODO instance variables
    // private List<CoffeeShop> mcoffeeShops;
    private Context mContext;

    // need a reference to itself (aka the lone singleton)
    private static CoffeeShopSingleton sSingleton;

    //TODO private singleton constructor
    private CoffeeShopSingleton(Context c) {
        mContext = c;
        // initialize arrayList
        // mcoffeeShops =  new ArrayList<>();
        // for demo purposes
//        for (int i = 1; i <= 10; i++) {
//            CoffeeShop shop = new CoffeeShop();
//            shop.setName("Coffee Shop "+ i);
//            shop.setCity("Taipei");
//            mcoffeeShops.add(shop);
//        }
    }

    //TODO Singleton get method
    public static CoffeeShopSingleton get(Context c) {
        // if the singleton doesn't exist yet, make one and return it
        // if it already exists, don't make one and return the original
        if (sSingleton == null) {
            sSingleton = new CoffeeShopSingleton(c);
        }
        return sSingleton;
    }

    //TODO getCoffeeShops (all items)

    public List<CoffeeShop> getAllCoffeeShops() {
//
//        return mcoffeeShops;
        return CoffeeShop.listAll(CoffeeShop.class);
    }

    //TODO getCoffeeShop (single item)
    public CoffeeShop getCoffeeShop(long id) {
        if (id >= 1) {
            return CoffeeShop.findById(CoffeeShop.class, id);
        }
        else{
            return null;
        }
    }

    //TODO addCoffeeShop
    public void addCoffeeShop(CoffeeShop shop) {
//        mcoffeeShops.add(shop);
        shop.save();
    }

    //TODO removeCoffeeShop
    public void removeCoffeeShop(long id) {
//        if (index >= 0 && index < mcoffeeShops.size()) {
//            mcoffeeShops.remove(index);
//        }
        if (id >= 1) {
            CoffeeShop shop = CoffeeShop.findById(CoffeeShop.class, id);
            if (shop != null) {
                shop.delete();
            }
        }

    }

    //TODO updateCoffeeShop
    public void updateCoffeeShop(long id, CoffeeShop cs) {
//        if (index >= 0 && index < mcoffeeShops.size()) {
//            mcoffeeShops.set(index, cs);
//        }
        if (id >= 1) {
            cs.setId(id);
            cs.save();
        }
    }

}
