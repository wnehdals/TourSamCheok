/*
 * Designed and developed by 2021 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.moviecompose.persistence.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jdm.toursamcheok.db.entity.TourEntity

open class KeywordListConverter {
  @TypeConverter
  fun fromString(value: String): List<TourEntity>? {
    val listType = object : TypeToken<List<TourEntity>>() {}.type
    return Gson().fromJson<List<TourEntity>>(value, listType)
  }

  @TypeConverter
  fun fromList(list: List<TourEntity>?): String {
    val gson = Gson()
    return gson.toJson(list)
  }
}