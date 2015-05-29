package club.texasholdem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import club.texasholdem.card.CardPackFactoryTest;
import club.texasholdem.card.CardPackTest;
import club.texasholdem.card.CardTest;
import club.texasholdem.card.RankTest;
import club.texasholdem.card.SuitTest;
import club.texasholdem.texas.BoardTest;
import club.texasholdem.texas.HandCombinationTest;
import club.texasholdem.texas.HandTest;
import club.texasholdem.texas.evaluation.HandEvaluatorTest;
import club.texasholdem.texas.evaluation.TestEvaluationData;

@RunWith(Suite.class)
@SuiteClasses({
CardPackFactoryTest.class,

CardPackTest.class,

CardTest.class,

RankTest.class, 

SuitTest.class,

BoardTest.class,

HandCombinationTest.class,

HandTest.class,

HandEvaluatorTest.class,

TestEvaluationData.class


})
public class TestsRunner {

}
