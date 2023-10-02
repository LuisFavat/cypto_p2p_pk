package ar.model.builders;

import ar.edu.unq.cryptop2p.model.Crypto;
import ar.edu.unq.cryptop2p.model.CryptoName;
import ar.edu.unq.cryptop2p.model.User;
import ar.edu.unq.cryptop2p.model.intention.Buy;
import ar.edu.unq.cryptop2p.model.intention.Intention;
import ar.edu.unq.cryptop2p.model.intention.Sell;

import java.time.LocalDateTime;
import java.util.Objects;

import static ar.model.factory.UserFactory.anyUser;

public class IntentionBuilder
{
    private Crypto crypto = new Crypto(CryptoName.BTCUSDT, LocalDateTime.now(), 30000);
    private float amount = 1;
    private User user = anyUser();
    private float intentionPrice = 30000f;
    public String typeOfBuild = "any";

    public IntentionBuilder() throws Exception {
    }


    public static IntentionBuilder anyIntention() throws Exception {
        return new IntentionBuilder();
    }
    public static IntentionBuilder buyIntention() throws Exception {
        var obj = new IntentionBuilder();
        obj.setTypeOfBuild("buy");
        return obj;
    }
    public static IntentionBuilder sellIntention() throws Exception {
        return new IntentionBuilder();
    }

    public void setTypeOfBuild(String typeOfBuild)
    {
        this.typeOfBuild = typeOfBuild;
    }

    public IntentionBuilder withCrypto(Crypto crypto)
    {
        this.crypto = crypto;
        return this;
    }

    public IntentionBuilder withAmount(float amount)
    {
        this.amount = amount;
        return this;
    }

    public IntentionBuilder withUser (User user)
    {
        this.user = user;
        return this;
    }

    public IntentionBuilder withIntentionPrice(float intentionPrice)
    {
        this.intentionPrice = intentionPrice;
        return this;
    }
    public Intention build() throws Exception {
        if(Objects.equals(this.typeOfBuild, "buy"))
        {
            return new Buy(crypto, amount, intentionPrice, user);
        }
        return  new Sell(crypto, amount, intentionPrice, user);
    }



}
