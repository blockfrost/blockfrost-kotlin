package org.openapitools.client.infrastructure

data class PaginationSetting(
    val count: Int,
    val page: Int = 1,
    val order: SortOrder = SortOrder.ASC,
    val allPages: Boolean = false,
) {

    companion object {
          fun allPages(): PaginationSetting {
              return PaginationSetting(-1, 1, SortOrder.ASC, true)
          }

          fun count(count: Int = 100): PaginationSetting {
              return PaginationSetting(count, 1, SortOrder.ASC, true)
          }

          fun first(count: Int = 100): PaginationSetting {
              return PaginationSetting(count, 1, SortOrder.ASC, true)
          }

          fun create(count: Int = 100, page: Int = 1, order: SortOrder = SortOrder.ASC): PaginationSetting {
              return PaginationSetting(count, page, order, false)
          }
    }
}

