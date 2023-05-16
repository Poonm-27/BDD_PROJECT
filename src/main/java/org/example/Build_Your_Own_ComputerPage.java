package org.example;

import org.openqa.selenium.By;

public class Build_Your_Own_ComputerPage extends Utils{
    private By _clickEmailAFriend = By.xpath("//div[@class='email-a-friend']/button");

    public void clickEmailAFriendButton()
    {
        //click on email a friend
        clickOnElement(_clickEmailAFriend);
    }

}
