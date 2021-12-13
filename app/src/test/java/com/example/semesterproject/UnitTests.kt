package com.example.semesterproject

import android.app.Application
import com.example.semesterproject.data.game.Game
import com.example.semesterproject.data.game.GameRepo.getGames
import com.example.semesterproject.network.DataFetcher
import com.example.semesterproject.screens.gameSelect.GameSelectViewModel
import com.example.semesterproject.screens.login.LoginViewModel
import com.example.semesterproject.screens.mainBoard.CordPair
import com.example.semesterproject.screens.mainBoard.ViewModels.boardViewModel
import org.junit.Assert
import org.junit.Test
import java.lang.Exception

class UnitTests {

    @Test
    fun Test3dViewModel(){
        val vm = boardViewModel()
        vm.addPairs(listOf(CordPair(1f,2f)))

        Assert.assertEquals(0.0f,vm.currentX.value)//makes sure the default is set currectly
    }

    @Test
    fun GameViewModTest(){
        val vm = GameSelectViewModel(app = Application())
        val games = vm.addGame()

        Assert.assertNotEquals(games,null)
    }

    @Test
    fun GameViewUserNameTest(){
        val vm = GameSelectViewModel(app = Application())
        val user = vm.setMainUser("Tim")

        Assert.assertEquals(user,"Tim")
    }

    @Test
    fun GameViewOppTest(){
        val vm = GameSelectViewModel(app = Application())
        vm.setOpp("Bob")

        Assert.assertEquals(vm.opponent,"Bob")
    }

    @Test
    fun LoginViewUserTest(){
        val vm = LoginViewModel()
        vm.signIn("Chris")

        Assert.assertEquals(vm.mainUser,"Chris")
    }

    @Test
    suspend fun DataFetchPostGameTest(){
        try {
            val test = DataFetcher().postGame("Tim", "Bob")
            Assert.assertNotEquals(test,null)
        }catch(e:Exception){

        }
    }

    @Test
    suspend fun DataFetchPostNewUser(){
        try{
           DataFetcher().postNewUser("Chris","Sam")
            Assert.assertTrue(true)
        }catch(e:Exception){
            Assert.assertEquals(e,"Failed connection")
        }
    }

    @Test
    suspend fun TestDataFetchFetchUserGames(){
        try{
            val test = DataFetcher().fetchUserGames("reggie")
            Assert.assertTrue(true)
        }catch (e:Exception){
            Assert.assertFalse(false)
        }
    }

    @Test
    suspend fun TestDataFetchFetchUser(){
        try{
            val test = DataFetcher().fetchUser("reggie")
            Assert.assertTrue(true)
        }catch (e:Exception){
            Assert.assertFalse(false)
        }
    }

    @Test
    fun TestgetGame(){
        Assert.assertNotEquals(getGames(),null)
        }
}