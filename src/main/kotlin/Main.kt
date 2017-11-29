import persistence.MongoImpl

import com.mongodb.*

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

fun main1(args: Array<String>) {

    //insert("{'name': 'BBBBBBBBBBBBB'}")
    //println(get("5a1e696dea1d0a0f34849efc"))
    //update("5a1e696dea1d0a0f34849efc", "{'name': 'XXXXXXXXXX'}")
    //println(get("5a1e696dea1d0a0f34849efc"))
    //delete("5a1e696dea1d0a0f34849efc")

}


// SECOND WAY
fun main(args: Array<String>) {
    val USER: String = "user"
    val PASS: String = "user"
    //val URL: String = "mongodb://$USER:$PASS@ds035438.mlab.com:35438/kotlin_mongo"
    val URL: String = "mongodb://127.0.0.1:27017/kotlin_mongo"

    var collection: DBCollection? = null
    val db: DB

    val basicDBObject =  BasicDBObject()
    basicDBObject.put("name", "Aurelio2")
    basicDBObject.put("age", 20)

    try {
        val mongoDB:MongoClient = MongoClient(MongoClientURI(URL))
        db = mongoDB.getDB("kotlin_mongo")
        collection = db.getCollection("customers_data")

        //INSERT
        collection.insert(basicDBObject)

        //GET
        val cursor = collection.find()
        while(cursor.hasNext())
            println(cursor.next())
    } catch (e: Exception) {
        println(e.message)
    }

}