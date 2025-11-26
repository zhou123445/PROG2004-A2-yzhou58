package com.scu.prvms;

import java.util.Comparator;

/**
 * Custom comparator for sorting Visitor objects: members first, then name ascending.
 */
public class VisitorComparator implements Comparator<Visitor> {
    /**
     * Compares two Visitor objects.
     * @param v1 First Visitor to compare
     * @param v2 Second Visitor to compare
     * @return Negative if v1 should come before v2, positive otherwise
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Members come first
        if (v1.isMember() && !v2.isMember()) return -1;
        if (!v1.isMember() && v2.isMember()) return 1;
        // Same membership status: sort by name ascending
        return v1.getName().compareTo(v2.getName());
    }
}