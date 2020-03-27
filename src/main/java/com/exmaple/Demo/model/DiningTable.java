package com.exmaple.Demo.model;

import java.util.*;

public class DiningTable {
    private int id;
    private String location;
    private int surplusnumber;
    private int sumnumber;
    private List<Chair> chairs = new List<Chair>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Chair> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            return null;
        }

        @Override
        public boolean add(Chair chair) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Chair> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, Collection<? extends Chair> collection) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Chair get(int i) {
            return null;
        }

        @Override
        public Chair set(int i, Chair chair) {
            return null;
        }

        @Override
        public void add(int i, Chair chair) {

        }

        @Override
        public Chair remove(int i) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Chair> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Chair> listIterator(int i) {
            return null;
        }

        @Override
        public List<Chair> subList(int i, int i1) {
            return null;
        }
    };

    @Override
    public String toString() {
        return "DiningTable{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", surplusnumber=" + surplusnumber +
                ", sumnumber=" + sumnumber +
                '}';
    }
    public List<Chair> getChairs() {
        return chairs;
    }

    public void setChairs(List<Chair> chairs) {
        this.chairs = chairs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSurplusnumber() {
        return surplusnumber;
    }

    public void setSurplusnumber(int surplusnumber) {
        this.surplusnumber = surplusnumber;
    }

    public int getSumnumber() {
        return sumnumber;
    }

    public void setSumnumber(int sumnumber) {
        this.sumnumber = sumnumber;
    }
}
