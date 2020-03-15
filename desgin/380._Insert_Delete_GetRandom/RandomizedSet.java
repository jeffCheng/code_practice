class RandomizedSet {
    /*
    Map -> containsKey to check if it exists
    Deal with Random -> How to get Random val -> ArrayList
    ArrayList feature
    remove is tricky part 
    only remove the last part 
    set new index to lastval
    map put new last value index
    list remove 
    map remove
    */
    Map<Integer,Integer> map;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size()); //consider index starts with zero
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        // list.remove(map.get(val)); ->list's remove still o(n)
        int index = map.get(val);
        int lastVal = list.get(list.size()-1);
        list.set(index,lastVal);
        list.remove(list.size()-1);
        map.put(lastVal,index);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */