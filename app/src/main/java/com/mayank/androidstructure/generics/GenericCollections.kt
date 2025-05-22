package com.mayank.androidstructure.generics

interface GenericCollections<T> {
    fun pop(): T?
    fun push(item: T)
    fun peek(): T?
}