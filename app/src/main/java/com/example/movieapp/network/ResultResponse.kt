package com.example.movieapp.network


/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class ResultResponse<out R> {

    data class Success<out T>(val data: T) : ResultResponse<T>()
    data class Error<out T>(val throwable: Throwable) : ResultResponse<T>()
    //    data class Loading<out T>(val any: Any) : Result<T>()
    data class Loading<out T>(val any: T) : ResultResponse<T>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$throwable]"
            is Loading -> "Loading[any=$any]"
        }
    }
}

/**
 * `true` if [RequestResult] is of type [Success] & holds non-null [Success.data].
 */
val ResultResponse<*>.succeeded
    get() = this is ResultResponse.Success && data != null