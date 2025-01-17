/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2022 Ta4j Organization & respective
 * authors (see AUTHORS)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.ta4j.core.criteria;

import static org.ta4j.core.TestUtils.assertNumEquals;

import java.util.function.Function;

import org.ta4j.core.AnalysisCriterion;
import org.ta4j.core.Position;
import org.ta4j.core.Trade;
import org.ta4j.core.mocks.MockBarSeries;
import org.ta4j.core.num.Num;

public class OpenedPositionUtils {

    public void testCalculateOneOpenPositionShouldReturnExpectedValue(Function<Number, Num> numFunction,
            AnalysisCriterion criterion, Num expectedValue) {
        MockBarSeries series = new MockBarSeries(numFunction, 100, 105, 110, 100, 95, 105);

        Position trade = new Position(Trade.TradeType.BUY);
        trade.operate(0, series.numOf(2.5), series.numOf(1));

        final Num value = criterion.calculate(series, trade);

        assertNumEquals(expectedValue, value);
    }

    public void testCalculateOneOpenPositionShouldReturnExpectedValue(Function<Number, Num> numFunction,
            AnalysisCriterion criterion, int expectedValue) {
        this.testCalculateOneOpenPositionShouldReturnExpectedValue(numFunction, criterion,
                numFunction.apply(expectedValue));
    }
}
