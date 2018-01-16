//package com.example.demographql;
//
//import org.dataloader.DataLoader;
//import org.dataloader.DataLoaderOptions;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//@Component
//public class LinkDataLoader extends DataLoader<Integer, List<Link>> {
//    public LinkDataLoader() {
//        this(null);
//    }
//
//    public LinkDataLoader(DataLoaderOptions options) {
//        super(keys -> CompletableFuture.supplyAsync(() -> {
//            List<List<Link>> result = new ArrayList<>(keys.size());
////      ...do some magic to fill result(using db, using slow device, etc)  ...
////      ...result must be in same order as keys ...
//            ArrayList<Link> e = new ArrayList<>();
//            e.add(new Link("aaaaa", "bbbbb", "ccccc", "1"));
//            result.add(e);
//            return result;
//        }), options);
//    }
//}
