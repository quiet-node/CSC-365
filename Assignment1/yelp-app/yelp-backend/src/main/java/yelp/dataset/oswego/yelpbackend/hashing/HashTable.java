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
        Description: Hash Table is an array of LinkedList, and each node::LinkedList is an instance of BusinessModel.
    */

 
    /* 
    - capacity indicates how big the table is, how many items the table can contain
    - size is the number of elements in the hashtable
    - threshold tells the table when to resize
    */
    private int capacity, threshold, size = 0; 
    private double loadFactor;
    private LinkedList<BusinessModel>[] table; // table is an array of Node 

    // Constructr
    public HashTable(int capacity, double loadFactor)  {
        this.capacity = capacity; 
        this.loadFactor = loadFactor;
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
        bucket.add(business);

        ++size; // increment size

        if (size > threshold) resize();

    };

    // resizes the table
    private void resize() {}


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

}
