package com.example.walletobserver.db.dao

import androidx.room.Dao
import com.example.walletobserver.db.entities.CategoryEntity

@Dao
interface CategoryDAO {

  fun getAllCategories():List<CategoryEntity>
}