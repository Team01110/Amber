package mapper

interface DataMapper<T> {
    fun toDomain(): T
}