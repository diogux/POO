package aula06;
import java.util.Vector;



public class Conjunto {
    private Vector<Integer> array = new Vector<>();
    
    public void insert(int n) {
        if (!array.contains(n)) {
            array.add(n);
        }
    }

    public boolean contains(int n) {
        for (int num : array) {
            if (num == n) {
                return true;
            }
        }
        return false;
    }

    public void remove(int n) {
        if (contains(n)) {
            array.remove(array.indexOf(n));
        }
    }

    public void empty() {
        array.clear();
    }

    

    public int size() {
        return array.size();
    }
    
    @SuppressWarnings("unchecked")
    public Conjunto unir(Conjunto c) {
        Conjunto unir = new Conjunto();
        unir.array = (Vector<Integer>) this.array.clone();

        for (int i : c.array) {
            if (!unir.contains(i)) {
                unir.insert(i);
            }
        }

        return unir;
    }
    @SuppressWarnings("unchecked")
    public Conjunto subtrair(Conjunto dif) {
        Conjunto sub = new Conjunto();
        sub.array = (Vector<Integer>) this.array.clone();

        for (int nr : dif.array) {
            if (sub.contains(nr)) {
                sub.remove(nr);
            }
        }

        return sub;
    }

    public Conjunto interset(Conjunto inter) {
        Conjunto intersecao = new Conjunto();
        
        for (int nr : inter.array) {
            if (this.contains(nr)) {
                intersecao.insert(nr);
            }
        }

        return intersecao;
    }

    


    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < array.size(); i++) {
            str += array.get(i) + " ";
        }
        return str;
    }

}
