package com.example.walletobserver.db

import com.example.walletobserver.db.entities.CategoryEntity
import com.example.walletobserver.db.entities.SubCategoryEntity

val listOfCategories = listOf(
  CategoryEntity(
    name = "Food & Drinks",
    subCategories = listOf(
      SubCategoryEntity(
        name = "General - Food & Drinks"
      ),
      SubCategoryEntity(
        name = "Bar, cafe"
      ),
      SubCategoryEntity(
        name = "Groceries"
      ),
      SubCategoryEntity(
        name = "Restaurant, fast-food"
      )
    )
  )
)