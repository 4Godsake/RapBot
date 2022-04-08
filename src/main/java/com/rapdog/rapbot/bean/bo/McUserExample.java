package com.rapdog.rapbot.bean.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class McUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public McUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserQidIsNull() {
            addCriterion("user_qid is null");
            return (Criteria) this;
        }

        public Criteria andUserQidIsNotNull() {
            addCriterion("user_qid is not null");
            return (Criteria) this;
        }

        public Criteria andUserQidEqualTo(Long value) {
            addCriterion("user_qid =", value, "userQid");
            return (Criteria) this;
        }

        public Criteria andUserQidNotEqualTo(Long value) {
            addCriterion("user_qid <>", value, "userQid");
            return (Criteria) this;
        }

        public Criteria andUserQidGreaterThan(Long value) {
            addCriterion("user_qid >", value, "userQid");
            return (Criteria) this;
        }

        public Criteria andUserQidGreaterThanOrEqualTo(Long value) {
            addCriterion("user_qid >=", value, "userQid");
            return (Criteria) this;
        }

        public Criteria andUserQidLessThan(Long value) {
            addCriterion("user_qid <", value, "userQid");
            return (Criteria) this;
        }

        public Criteria andUserQidLessThanOrEqualTo(Long value) {
            addCriterion("user_qid <=", value, "userQid");
            return (Criteria) this;
        }

        public Criteria andUserQidIn(List<Long> values) {
            addCriterion("user_qid in", values, "userQid");
            return (Criteria) this;
        }

        public Criteria andUserQidNotIn(List<Long> values) {
            addCriterion("user_qid not in", values, "userQid");
            return (Criteria) this;
        }

        public Criteria andUserQidBetween(Long value1, Long value2) {
            addCriterion("user_qid between", value1, value2, "userQid");
            return (Criteria) this;
        }

        public Criteria andUserQidNotBetween(Long value1, Long value2) {
            addCriterion("user_qid not between", value1, value2, "userQid");
            return (Criteria) this;
        }

        public Criteria andUserMcidIsNull() {
            addCriterion("user_mcid is null");
            return (Criteria) this;
        }

        public Criteria andUserMcidIsNotNull() {
            addCriterion("user_mcid is not null");
            return (Criteria) this;
        }

        public Criteria andUserMcidEqualTo(String value) {
            addCriterion("user_mcid =", value, "userMcid");
            return (Criteria) this;
        }

        public Criteria andUserMcidNotEqualTo(String value) {
            addCriterion("user_mcid <>", value, "userMcid");
            return (Criteria) this;
        }

        public Criteria andUserMcidGreaterThan(String value) {
            addCriterion("user_mcid >", value, "userMcid");
            return (Criteria) this;
        }

        public Criteria andUserMcidGreaterThanOrEqualTo(String value) {
            addCriterion("user_mcid >=", value, "userMcid");
            return (Criteria) this;
        }

        public Criteria andUserMcidLessThan(String value) {
            addCriterion("user_mcid <", value, "userMcid");
            return (Criteria) this;
        }

        public Criteria andUserMcidLessThanOrEqualTo(String value) {
            addCriterion("user_mcid <=", value, "userMcid");
            return (Criteria) this;
        }

        public Criteria andUserMcidLike(String value) {
            addCriterion("user_mcid like", value, "userMcid");
            return (Criteria) this;
        }

        public Criteria andUserMcidNotLike(String value) {
            addCriterion("user_mcid not like", value, "userMcid");
            return (Criteria) this;
        }

        public Criteria andUserMcidIn(List<String> values) {
            addCriterion("user_mcid in", values, "userMcid");
            return (Criteria) this;
        }

        public Criteria andUserMcidNotIn(List<String> values) {
            addCriterion("user_mcid not in", values, "userMcid");
            return (Criteria) this;
        }

        public Criteria andUserMcidBetween(String value1, String value2) {
            addCriterion("user_mcid between", value1, value2, "userMcid");
            return (Criteria) this;
        }

        public Criteria andUserMcidNotBetween(String value1, String value2) {
            addCriterion("user_mcid not between", value1, value2, "userMcid");
            return (Criteria) this;
        }

        public Criteria andUserStatIsNull() {
            addCriterion("user_stat is null");
            return (Criteria) this;
        }

        public Criteria andUserStatIsNotNull() {
            addCriterion("user_stat is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatEqualTo(String value) {
            addCriterion("user_stat =", value, "userStat");
            return (Criteria) this;
        }

        public Criteria andUserStatNotEqualTo(String value) {
            addCriterion("user_stat <>", value, "userStat");
            return (Criteria) this;
        }

        public Criteria andUserStatGreaterThan(String value) {
            addCriterion("user_stat >", value, "userStat");
            return (Criteria) this;
        }

        public Criteria andUserStatGreaterThanOrEqualTo(String value) {
            addCriterion("user_stat >=", value, "userStat");
            return (Criteria) this;
        }

        public Criteria andUserStatLessThan(String value) {
            addCriterion("user_stat <", value, "userStat");
            return (Criteria) this;
        }

        public Criteria andUserStatLessThanOrEqualTo(String value) {
            addCriterion("user_stat <=", value, "userStat");
            return (Criteria) this;
        }

        public Criteria andUserStatLike(String value) {
            addCriterion("user_stat like", value, "userStat");
            return (Criteria) this;
        }

        public Criteria andUserStatNotLike(String value) {
            addCriterion("user_stat not like", value, "userStat");
            return (Criteria) this;
        }

        public Criteria andUserStatIn(List<String> values) {
            addCriterion("user_stat in", values, "userStat");
            return (Criteria) this;
        }

        public Criteria andUserStatNotIn(List<String> values) {
            addCriterion("user_stat not in", values, "userStat");
            return (Criteria) this;
        }

        public Criteria andUserStatBetween(String value1, String value2) {
            addCriterion("user_stat between", value1, value2, "userStat");
            return (Criteria) this;
        }

        public Criteria andUserStatNotBetween(String value1, String value2) {
            addCriterion("user_stat not between", value1, value2, "userStat");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNull() {
            addCriterion("user_role is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNotNull() {
            addCriterion("user_role is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleEqualTo(String value) {
            addCriterion("user_role =", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotEqualTo(String value) {
            addCriterion("user_role <>", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThan(String value) {
            addCriterion("user_role >", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThanOrEqualTo(String value) {
            addCriterion("user_role >=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThan(String value) {
            addCriterion("user_role <", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThanOrEqualTo(String value) {
            addCriterion("user_role <=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLike(String value) {
            addCriterion("user_role like", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotLike(String value) {
            addCriterion("user_role not like", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleIn(List<String> values) {
            addCriterion("user_role in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotIn(List<String> values) {
            addCriterion("user_role not in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleBetween(String value1, String value2) {
            addCriterion("user_role between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotBetween(String value1, String value2) {
            addCriterion("user_role not between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andMcPositionIsNull() {
            addCriterion("mc_position is null");
            return (Criteria) this;
        }

        public Criteria andMcPositionIsNotNull() {
            addCriterion("mc_position is not null");
            return (Criteria) this;
        }

        public Criteria andMcPositionEqualTo(String value) {
            addCriterion("mc_position =", value, "mcPosition");
            return (Criteria) this;
        }

        public Criteria andMcPositionNotEqualTo(String value) {
            addCriterion("mc_position <>", value, "mcPosition");
            return (Criteria) this;
        }

        public Criteria andMcPositionGreaterThan(String value) {
            addCriterion("mc_position >", value, "mcPosition");
            return (Criteria) this;
        }

        public Criteria andMcPositionGreaterThanOrEqualTo(String value) {
            addCriterion("mc_position >=", value, "mcPosition");
            return (Criteria) this;
        }

        public Criteria andMcPositionLessThan(String value) {
            addCriterion("mc_position <", value, "mcPosition");
            return (Criteria) this;
        }

        public Criteria andMcPositionLessThanOrEqualTo(String value) {
            addCriterion("mc_position <=", value, "mcPosition");
            return (Criteria) this;
        }

        public Criteria andMcPositionLike(String value) {
            addCriterion("mc_position like", value, "mcPosition");
            return (Criteria) this;
        }

        public Criteria andMcPositionNotLike(String value) {
            addCriterion("mc_position not like", value, "mcPosition");
            return (Criteria) this;
        }

        public Criteria andMcPositionIn(List<String> values) {
            addCriterion("mc_position in", values, "mcPosition");
            return (Criteria) this;
        }

        public Criteria andMcPositionNotIn(List<String> values) {
            addCriterion("mc_position not in", values, "mcPosition");
            return (Criteria) this;
        }

        public Criteria andMcPositionBetween(String value1, String value2) {
            addCriterion("mc_position between", value1, value2, "mcPosition");
            return (Criteria) this;
        }

        public Criteria andMcPositionNotBetween(String value1, String value2) {
            addCriterion("mc_position not between", value1, value2, "mcPosition");
            return (Criteria) this;
        }

        public Criteria andUserPointIsNull() {
            addCriterion("user_point is null");
            return (Criteria) this;
        }

        public Criteria andUserPointIsNotNull() {
            addCriterion("user_point is not null");
            return (Criteria) this;
        }

        public Criteria andUserPointEqualTo(Integer value) {
            addCriterion("user_point =", value, "userPoint");
            return (Criteria) this;
        }

        public Criteria andUserPointNotEqualTo(Integer value) {
            addCriterion("user_point <>", value, "userPoint");
            return (Criteria) this;
        }

        public Criteria andUserPointGreaterThan(Integer value) {
            addCriterion("user_point >", value, "userPoint");
            return (Criteria) this;
        }

        public Criteria andUserPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_point >=", value, "userPoint");
            return (Criteria) this;
        }

        public Criteria andUserPointLessThan(Integer value) {
            addCriterion("user_point <", value, "userPoint");
            return (Criteria) this;
        }

        public Criteria andUserPointLessThanOrEqualTo(Integer value) {
            addCriterion("user_point <=", value, "userPoint");
            return (Criteria) this;
        }

        public Criteria andUserPointIn(List<Integer> values) {
            addCriterion("user_point in", values, "userPoint");
            return (Criteria) this;
        }

        public Criteria andUserPointNotIn(List<Integer> values) {
            addCriterion("user_point not in", values, "userPoint");
            return (Criteria) this;
        }

        public Criteria andUserPointBetween(Integer value1, Integer value2) {
            addCriterion("user_point between", value1, value2, "userPoint");
            return (Criteria) this;
        }

        public Criteria andUserPointNotBetween(Integer value1, Integer value2) {
            addCriterion("user_point not between", value1, value2, "userPoint");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andExtAIsNull() {
            addCriterion("ext_a is null");
            return (Criteria) this;
        }

        public Criteria andExtAIsNotNull() {
            addCriterion("ext_a is not null");
            return (Criteria) this;
        }

        public Criteria andExtAEqualTo(String value) {
            addCriterion("ext_a =", value, "extA");
            return (Criteria) this;
        }

        public Criteria andExtANotEqualTo(String value) {
            addCriterion("ext_a <>", value, "extA");
            return (Criteria) this;
        }

        public Criteria andExtAGreaterThan(String value) {
            addCriterion("ext_a >", value, "extA");
            return (Criteria) this;
        }

        public Criteria andExtAGreaterThanOrEqualTo(String value) {
            addCriterion("ext_a >=", value, "extA");
            return (Criteria) this;
        }

        public Criteria andExtALessThan(String value) {
            addCriterion("ext_a <", value, "extA");
            return (Criteria) this;
        }

        public Criteria andExtALessThanOrEqualTo(String value) {
            addCriterion("ext_a <=", value, "extA");
            return (Criteria) this;
        }

        public Criteria andExtALike(String value) {
            addCriterion("ext_a like", value, "extA");
            return (Criteria) this;
        }

        public Criteria andExtANotLike(String value) {
            addCriterion("ext_a not like", value, "extA");
            return (Criteria) this;
        }

        public Criteria andExtAIn(List<String> values) {
            addCriterion("ext_a in", values, "extA");
            return (Criteria) this;
        }

        public Criteria andExtANotIn(List<String> values) {
            addCriterion("ext_a not in", values, "extA");
            return (Criteria) this;
        }

        public Criteria andExtABetween(String value1, String value2) {
            addCriterion("ext_a between", value1, value2, "extA");
            return (Criteria) this;
        }

        public Criteria andExtANotBetween(String value1, String value2) {
            addCriterion("ext_a not between", value1, value2, "extA");
            return (Criteria) this;
        }

        public Criteria andExtBIsNull() {
            addCriterion("ext_b is null");
            return (Criteria) this;
        }

        public Criteria andExtBIsNotNull() {
            addCriterion("ext_b is not null");
            return (Criteria) this;
        }

        public Criteria andExtBEqualTo(String value) {
            addCriterion("ext_b =", value, "extB");
            return (Criteria) this;
        }

        public Criteria andExtBNotEqualTo(String value) {
            addCriterion("ext_b <>", value, "extB");
            return (Criteria) this;
        }

        public Criteria andExtBGreaterThan(String value) {
            addCriterion("ext_b >", value, "extB");
            return (Criteria) this;
        }

        public Criteria andExtBGreaterThanOrEqualTo(String value) {
            addCriterion("ext_b >=", value, "extB");
            return (Criteria) this;
        }

        public Criteria andExtBLessThan(String value) {
            addCriterion("ext_b <", value, "extB");
            return (Criteria) this;
        }

        public Criteria andExtBLessThanOrEqualTo(String value) {
            addCriterion("ext_b <=", value, "extB");
            return (Criteria) this;
        }

        public Criteria andExtBLike(String value) {
            addCriterion("ext_b like", value, "extB");
            return (Criteria) this;
        }

        public Criteria andExtBNotLike(String value) {
            addCriterion("ext_b not like", value, "extB");
            return (Criteria) this;
        }

        public Criteria andExtBIn(List<String> values) {
            addCriterion("ext_b in", values, "extB");
            return (Criteria) this;
        }

        public Criteria andExtBNotIn(List<String> values) {
            addCriterion("ext_b not in", values, "extB");
            return (Criteria) this;
        }

        public Criteria andExtBBetween(String value1, String value2) {
            addCriterion("ext_b between", value1, value2, "extB");
            return (Criteria) this;
        }

        public Criteria andExtBNotBetween(String value1, String value2) {
            addCriterion("ext_b not between", value1, value2, "extB");
            return (Criteria) this;
        }

        public Criteria andExtCIsNull() {
            addCriterion("ext_c is null");
            return (Criteria) this;
        }

        public Criteria andExtCIsNotNull() {
            addCriterion("ext_c is not null");
            return (Criteria) this;
        }

        public Criteria andExtCEqualTo(String value) {
            addCriterion("ext_c =", value, "extC");
            return (Criteria) this;
        }

        public Criteria andExtCNotEqualTo(String value) {
            addCriterion("ext_c <>", value, "extC");
            return (Criteria) this;
        }

        public Criteria andExtCGreaterThan(String value) {
            addCriterion("ext_c >", value, "extC");
            return (Criteria) this;
        }

        public Criteria andExtCGreaterThanOrEqualTo(String value) {
            addCriterion("ext_c >=", value, "extC");
            return (Criteria) this;
        }

        public Criteria andExtCLessThan(String value) {
            addCriterion("ext_c <", value, "extC");
            return (Criteria) this;
        }

        public Criteria andExtCLessThanOrEqualTo(String value) {
            addCriterion("ext_c <=", value, "extC");
            return (Criteria) this;
        }

        public Criteria andExtCLike(String value) {
            addCriterion("ext_c like", value, "extC");
            return (Criteria) this;
        }

        public Criteria andExtCNotLike(String value) {
            addCriterion("ext_c not like", value, "extC");
            return (Criteria) this;
        }

        public Criteria andExtCIn(List<String> values) {
            addCriterion("ext_c in", values, "extC");
            return (Criteria) this;
        }

        public Criteria andExtCNotIn(List<String> values) {
            addCriterion("ext_c not in", values, "extC");
            return (Criteria) this;
        }

        public Criteria andExtCBetween(String value1, String value2) {
            addCriterion("ext_c between", value1, value2, "extC");
            return (Criteria) this;
        }

        public Criteria andExtCNotBetween(String value1, String value2) {
            addCriterion("ext_c not between", value1, value2, "extC");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}