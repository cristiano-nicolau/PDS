import java.util.*;

public class ToShare {
    private List<Product> products;
    private Map<Product, Client> sharedProducts;
    private Map<Product, Queue<Client>> waitingList;
    private Map<Product, List<Client>> observers;

    public ToShare() {
        this.products = new ArrayList<>();
        this.sharedProducts = new HashMap<>();
        this.waitingList = new HashMap<>();
        this.observers = new HashMap<>();
    }

    public boolean add(Product p) {
        return products.add(p);
    }

    public Product remove(String code) {
        for (Product p : products) {
            if (p.code().equals(code)) {
                products.remove(p);
                sharedProducts.remove(p);
                waitingList.remove(p);
                observers.remove(p);
                return p;
            }
        }
        return null;
    }

    public Product remove(Product p) {
        if (products.remove(p)) {
            sharedProducts.remove(p);
            waitingList.remove(p);
            observers.remove(p);
            return p;
        }
        return null;
    }

    public boolean share(String code, Client user) {
        for (Product p : products) {
            if (p.code().equals(code)) {
                return share(p, user);
            }
        }
        return false;
    }

    public boolean share(Product p, Client user) {
        if (sharedProducts.containsKey(p)) {
            waitingList.computeIfAbsent(p, k -> new LinkedList<>()).add(user);
            observers.computeIfAbsent(p, k -> new ArrayList<>()).add(user);
            return false;
        } else {
            sharedProducts.put(p, user);
            return true;
        }
    }

    public boolean giveBack(String code) {
        for (Product p : products) {
            if (p.code().equals(code)) {
                return giveBack(p);
            }
        }
        return false;
    }

    public boolean giveBack(Product p) {
        if (sharedProducts.containsKey(p)) {
            sharedProducts.remove(p);
            notifyObservers(p);
            if (waitingList.containsKey(p) && !waitingList.get(p).isEmpty()) {
                Client nextClient = waitingList.get(p).poll();
                sharedProducts.put(p, nextClient);
            }
            return true;
        }
        return false;
    }

    private void notifyObservers(Product p) {
        if (observers.containsKey(p)) {
            for (Client c : observers.get(p)) {
                System.out.println("Notify " + c + " that " + p.code() + " is available.");
            }
            observers.remove(p);
        }
    }

    public String allAlugados() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Product, Client> entry : sharedProducts.entrySet()) {
            sb.append(entry.getKey()).append(" shared with ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    public void readProducts(List<Product> productList) {
        this.products.addAll(productList);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Map<Product, Client> sharedProducts() {
        return Collections.unmodifiableMap(sharedProducts);
    }

}
