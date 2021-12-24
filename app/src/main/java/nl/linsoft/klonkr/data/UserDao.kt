package nl.linsoft.klonkr.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: User)

    @Query("DELETE FROM questions_table")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM questions_table WHERE id = :id")
    suspend fun deleteUser(id: Int)

    @Query("SELECT * FROM questions_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}