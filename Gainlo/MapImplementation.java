/*
Implement data structure “Map” storing pairs of integers (key, value)
and define following member functions in O(1) runtime:

void insert(key, value),
void delete(key),
int get(key),
int getRandomKey().
*/

package gainlo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class MapImplementation
{
    private HashMap<Integer, ArrayList<Integer>> hm;
    private int[] keys;
    private int length;

    public MapImplementation()
    {
        this.hm = new HashMap<Integer, ArrayList<Integer>>();
        this.keys = new int[100];   // LESSON: ARRAY - A fixed array can be dynamically resized using length flag with some space wastage.
        this.length = 0;
    }

    public void set(int key, int value)
    {
        ArrayList<Integer> values = new ArrayList<Integer>();
        values.add(value);
        values.add(this.length);
        this.hm.put(key, values);

        this.keys[this.length] = key;
        this.length += 1;
    }

    public int get(int key)
    {
        ArrayList<Integer> values = this.hm.get(key);
        if(values == null)
        {
            return -1;
        }
        else
        {
            return values.get(0);
        }
    }

    public void delete(int key)
    {
        ArrayList<Integer> values = this.hm.get(key);

        if(values != null)
        {
            int index = values.get(1);

            if(index != this.length - 1)
            {
                this.keys[index] = this.keys[this.length - 1];

                ArrayList<Integer> replacedKeyValues = this.hm.get(this.keys[index]);
                replacedKeyValues.set(1, index);
                this.hm.put(this.keys[index], replacedKeyValues);
            }

            this.length -= 1;
            this.hm.remove(key);
        }
    }

    public int getRandomKey()
    {
        Random random = new Random();
        int randomIndex = random.nextInt(this.length + 1);
        return this.keys[randomIndex];
    }

    public int size()
    {
        return this.hm.size();
    }

    public void printAll()
    {
        for(int key : this.hm.keySet())
        {
            System.out.print(this.hm.get(key) + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        MapImplementation map = new MapImplementation();

        System.out.println("Setting 1"); map.set(1, 100);
        System.out.println("Setting 2"); map.set(2, 200);
        System.out.println("Setting 3"); map.set(3, 300);
        System.out.println("Current size: " + map.size());

        System.out.println("Getting 2: " + map.get(2));

        map.delete(2); System.out.println("Deleting 2. New size: " + map.size()); map.printAll();
        map.delete(3); System.out.println("Deleting 3. New size: " + map.size()); map.printAll();

        System.out.println("Getting 3: " + map.get(3));

        System.out.println("Setting 2"); map.set(2, 200);

        System.out.println("Getting 2: " + map.get(2));

        System.out.println("Random Key: " + map.getRandomKey());
        System.out.println("Random Key: " + map.getRandomKey());
        System.out.println("Random Key: " + map.getRandomKey());
    }
}
