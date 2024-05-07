package com.example.new_gymsarround_app

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.new_gymsarround_app.DummyGymsList.getDummyGymsList
import com.example.new_gymsarround_app.gyms.presentation.SemanticDescription
import com.example.new_gymsarround_app.gyms.presentation.gymsList.GymsScreen
import com.example.new_gymsarround_app.gyms.presentation.gymsList.GymsScreenState
import com.example.new_gymsarround_app.ui.theme.New_GymsArround_AppTheme
import org.junit.Rule
import org.junit.Test

class GymsScreenTest {

    // add functionalities to test
    //how to test compose Ui in this class
    @get:Rule
    val testRule : ComposeContentTestRule = createComposeRule()
    //there are 3 states in GymsScreen (loading-error-afterLoading)
    //test Loading State
    @Test
    fun loadingState_IsActive()
    {
        testRule.setContent {
            // wrapping the screen to test (environment)
            New_GymsArround_AppTheme {
                GymsScreen(
                    state = GymsScreenState(gyms = emptyList(),isLoading = true) ,
                    onItemClick ={} ,
                    onFavouriteIconClick = {_:Int ,_:Boolean->})
            }
        }
        // ensure that this element is displayed on the screen
        testRule.onNodeWithContentDescription(SemanticDescription.Gyms_List_Loadind).assertIsDisplayed()
    }


    //test Loading State
    @Test
    fun loadedContentState_IsActive()
    {
        val gymsList=getDummyGymsList()

        testRule.setContent {
            // wrapping the screen to test (environment)
            New_GymsArround_AppTheme {
                GymsScreen(
                    state = GymsScreenState(gyms = gymsList,isLoading = false) ,
                    onItemClick ={} ,
                    onFavouriteIconClick = {_:Int ,_:Boolean->})
            }
        }

        testRule.onNodeWithText(gymsList[0].name).assertIsDisplayed()
        testRule.onNodeWithContentDescription(SemanticDescription.Gyms_List_Loadind).assertDoesNotExist()

    }


    @Test
    fun errorState_IsActive()
    {
        val errorText="Failed to Load Data"

        testRule.setContent {
            // wrapping the screen to test (environment)
            New_GymsArround_AppTheme {
                GymsScreen(
                    state = GymsScreenState(gyms = emptyList(),isLoading = false,error=errorText) ,
                    onItemClick ={} ,
                    onFavouriteIconClick = {_:Int ,_:Boolean->})
            }
        }

        testRule.onNodeWithText(errorText).assertIsDisplayed()
        testRule.onNodeWithContentDescription(SemanticDescription.Gyms_List_Loadind).assertDoesNotExist()
    }



    @Test
    fun onClickItem_IdIsPassedCorrectly(){
        val gymsList=getDummyGymsList()
        val gymItem =gymsList[0]

        testRule.setContent {
            // wrapping the screen to test (environment) loaded state
            New_GymsArround_AppTheme {
                GymsScreen(
                    state = GymsScreenState(gyms = gymsList,isLoading = false) ,
                    onItemClick ={id->
                        assert(id==gymItem.id)
                    } ,
                    onFavouriteIconClick = {_:Int ,_:Boolean->})
            }
        }
        //perform click
        testRule.onNodeWithText(gymItem.name).performClick()
    }


}