package persistence

/**
 * Created by data-mc on 11/29/2017.
 */
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters.eq
import org.bson.Document
import org.bson.types.ObjectId

class MongoImpl
    constructor() : Mongo {

    private val client: MongoClient = MongoClient(MongoClientURI("mongodb://127.0.0.1:27017"))
    private val db: MongoDatabase = client.getDatabase("kms")
    private val docs: MongoCollection<Document> = db.getCollection("docs")

    override fun get(id: String): String? {
        return docs.find(eq("_id", ObjectId(id)))?.first()?.toJson()
    }

    override fun insert(doc: String) {
        docs.insertOne(Document.parse(doc))
    }

    override fun delete(id: String): Long {
        return db.getCollection("docs").deleteOne(eq("_id", ObjectId(id))).deletedCount
    }

    override fun update(id: String, doc: String) {
        db.getCollection("docs").updateOne(eq("_id", ObjectId(id)), Document("\$set", Document.parse(doc)))
    }
}