import persistence.MongoImpl

/**
 * Created by data-mc on 11/29/2017.
 */

/*
DOCUMENTATION
http://mongodb.github.io/mongo-java-driver/3.5/driver/
 */
val mongo = MongoImpl()

fun get(id: String)
        = mongo.get(id) ?: "Document with id=[$id] is not found"

fun insert(doc: String)
        = mongo.insert(doc)

fun delete(id: String)
        = mongo.delete(id)

fun update(id: String, doc: String)
        = mongo.update(id, doc)

fun main(args: Array<String>) {

    //insert("{'name': 'BBBBBBBBBBBBB'}")
    println(get("5a1e696dea1d0a0f34849efc"))
    update("5a1e696dea1d0a0f34849efc", "{'name': 'XXXXXXXXXX'}")
    println(get("5a1e696dea1d0a0f34849efc"))
    delete("5a1e696dea1d0a0f34849efc")

}
