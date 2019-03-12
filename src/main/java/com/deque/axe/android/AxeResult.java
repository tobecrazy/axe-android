package com.deque.axe.android;

import com.deque.axe.android.constants.AxeStatus;
import com.deque.axe.android.utils.JsonSerializable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AxeResult implements JsonSerializable {

  public final AxeConf axeConf;

  public final AxeContext axeContext;

  public final List<AxeRuleResult> axeRuleResults;

  AxeResult(
      final AxeConf axeConf,
      final AxeContext axeContext,
      final List<AxeRuleResult> axeRuleResults
  ) {
    this.axeConf = axeConf;
    this.axeContext = axeContext;
    this.axeRuleResults = axeRuleResults;
  }

  AxeResult(final AxeConf axeConf, final AxeContext axeContext) {
    this(axeConf, axeContext, new LinkedList<>());
  }

  void add(final AxeRuleResult axeRuleResult) {
    if (!axeRuleResult.status.equals(AxeStatus.INAPPLICABLE)) {
      axeRuleResults.add(axeRuleResult);
    }
  }
}