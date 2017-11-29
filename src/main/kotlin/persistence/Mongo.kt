package persistence

/**
 * Created by data-mc on 11/29/2017.
 */
interface Mongo {

    fun get(id: String): String?
    fun insert(doc: String)
    fun delete(id: String): Long
    fun update(id: String, doc: String)
}