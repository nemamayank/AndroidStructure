package com.mayank.androidstructure.generics

class Queue<T>: GenericCollections<T> {
    private var items: MutableList<T> = mutableListOf()
    override fun pop(): T? {
        return items.removeLastOrNull()
    }
    override fun peek(): T? {
        return items.lastOrNull()
    }
    override fun push(item: T) {
        items.add(item)
    }
}