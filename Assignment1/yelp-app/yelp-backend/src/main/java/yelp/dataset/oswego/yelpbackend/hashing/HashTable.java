package yelp.dataset.oswego.yelpbackend.hashing;

import java.util.LinkedList;

import yelp.dataset.oswego.yelpbackend.models.BusinessModel;

public class HashTable {

    static final class Node {
        BusinessModel business;
        Node next;

        Node(BusinessModel business, Node next) {
            this.business = business;
            this.next = next;
        }
    }
    /* 
        DESCRIPTION: Hash Table is an array of LinkedList, and each node::LinkedList is an instance of BusinessModel.
    */

 
    /* 
    - capacity indicates how big the table is, how many items the table can contain
    - size is the number of elements in the hashtable
    - threshold tells the table when to resize
    */
    private int capacity, threshold, size = 0; 
    private double loadFactor = 0.75;
    private LinkedList<BusinessModel>[] table; // table is an array of Node 

    // Constructr
    public HashTable(int capacity)  {
        this.capacity = capacity; 
        threshold = (int) (this.capacity*loadFactor);
        table = new LinkedList[this.capacity];  
    }

    // unhashedIndex() normalizes the HashCode to find the index for each bucket
    private int unhashedIndex(int hashedIndex) {
        return (hashedIndex & 0x7FFFFFFF) & (this.capacity - 1); // 0x7FFFFFFF strips off the sign bit makes it always positive
    }


    // add() use to insert business into the hashtable
    public void add(BusinessModel business) {
        if (business == null) throw new IllegalArgumentException("Null key");

        // find  the bucketIdex it belongs too
        int bucketIndex = unhashedIndex(business.hashCode()); 

        // loop through the bucket at table[bucketIndex]
        LinkedList<BusinessModel> bucket = table[bucketIndex];

        if (bucket == null) table[bucketIndex] = bucket = new LinkedList<BusinessModel>(); // fix NullPointer 

        bucket.add(business); 

        ++size; // increment size

        if (size > threshold) resize(); // resize if threshold is reached

    };

    // resizes the table
    private void resize() {
        capacity = table.length << 1; // new capacity left shift 1 == 2x
        threshold = (int) (capacity * loadFactor);  //new threshold
        LinkedList<BusinessModel>[] newTable = new LinkedList[capacity];

        // loop through table 
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                // each index on the table is a linkedlist of BusinessModel
                for(BusinessModel b : table[i]) {
                    // For each b in linkedlist table[i], get bucketIndex
                    int bucketIndex = unhashedIndex(b.hashCode());
                    LinkedList<BusinessModel> bucket = newTable[bucketIndex];

                    if (bucket == null) newTable[bucketIndex] = bucket = new LinkedList<BusinessModel>(); // fix NullPointer
                    bucket.add(b);

                } // finished adding all the business from old table to new table
            }

        }

        table = newTable; 

    }


    // check if bucket has business
    public boolean contains(BusinessModel business) {
        int bucketIndex = unhashedIndex(business.hashCode());
        LinkedList<BusinessModel> bucket = table[bucketIndex];

        // loop through the bucket to find if it contains business
        for (BusinessModel b : bucket) {
            if (b == business) return true;
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }
    public LinkedList<BusinessModel> getBusiness() {
        return table[0];
    }

}
