package itp341.exercises.week9_list_singleton.app.model;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//TODO complete
public class CoffeeShopSingleton {

    //TODO instance variables
    private List<CoffeeShop> mCoffeeShops;
    private Context mContext;

    //reference to itself (aka the lone singleton)
    private static CoffeeShopSingleton sSingleton;


    //TODO private singleton constructor
    private CoffeeShopSingleton(Context c) {
        mContext = c;
        //initialize arraylist
       // mCoffeeShops = new ArrayList<>();
        //for demo purposes
//        for (int i = 1; i < 10; i++) {
//            CoffeeShop shop = new CoffeeShop();
//            shop.setName("Coffee Shop " + i);
//            shop.setCity("Taipei");
//            mCoffeeShops.add(shop);
//        }

    }


    //TODO Singleton get method
    public static CoffeeShopSingleton get(Context c) {
        //if the singleton doesn't exist yet, make one and return it
        //if it already, DONT MAKE ONE and just return the original
        if (sSingleton == null) {
            sSingleton = new CoffeeShopSingleton(c);
        }
        return sSingleton;
    }


    //TODO getCoffeeShops (all items)

    public List<CoffeeShop> getAllCoffeeShops() {
//        return mCoffeeShops;
        return CoffeeShop.listAll(CoffeeShop.class);
    }
//    }


    //TODO getCoffeeShop (single item)
    public CoffeeShop getCoffeeShop(long id) {
        if (id >= 1) {
            return CoffeeShop.findById(CoffeeShop.class, id);
        }
        else {
            return null;
        }
    }

    //TODO addCoffeeShop
    public void addCoffeeShop(CoffeeShop shop) {
//        mCoffeeShops.add(shop);
        shop.save();
    }


    //TODO removeCoffeeShop
    public void removeCoffeeShop(long id) {
//        if (index >= 0 && index < mCoffeeShops.size()) {
//            mCoffeeShops.remove(index);
//        }
        CoffeeShop shop = CoffeeShop.findById(CoffeeShop.class, id);
        if(shop != null) {
            shop.delete();
        }
    }


    //TODO updateCoffeeShop
    public void updateCoffeeShop(long id, CoffeeShop cs) {
//        if (index >= 0 && index < mCoffeeShops.size()){
//            mCoffeeShops.set(index, cs);
//        }
        if(id >=1) {
            cs.setId(id); //since this model has an ID, it will update that record
            //without an ID, it will add a new record
            cs.save();
        }

    }

}






