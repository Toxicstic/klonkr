package nl.linsoft.klonkr.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun deleteUser(id: Int) {
        userDao.deleteUser(id)
    }

    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }

}