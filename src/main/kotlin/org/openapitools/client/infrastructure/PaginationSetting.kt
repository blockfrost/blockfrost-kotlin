package org.openapitools.client.infrastructure

data class PaginationSetting(
    val count: Int,
    val page: Int = 1,
    val order: Order = Order.ASC,
    val allPages: Boolean = false,
) {

    companion object {
          fun allPages(): PaginationSetting {
              return PaginationSetting(0, 1, Order.ASC, true)
          }

          fun count(count: Int): PaginationSetting {
              return PaginationSetting(count, 1, Order.ASC, true)
          }

          fun create(count: Int, page: Int = 1, order: Order = Order.ASC): PaginationSetting {
              return PaginationSetting(count, page, order, false)
          }
    }

    enum class Order {
        ASC, DESC
    }
}

