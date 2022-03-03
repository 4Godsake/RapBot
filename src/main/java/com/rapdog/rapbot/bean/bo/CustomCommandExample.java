package com.rapdog.rapbot.bean.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomCommandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomCommandExample() {
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

        public Criteria andCommandStrIsNull() {
            addCriterion("command_str is null");
            return (Criteria) this;
        }

        public Criteria andCommandStrIsNotNull() {
            addCriterion("command_str is not null");
            return (Criteria) this;
        }

        public Criteria andCommandStrEqualTo(String value) {
            addCriterion("command_str =", value, "commandStr");
            return (Criteria) this;
        }

        public Criteria andCommandStrNotEqualTo(String value) {
            addCriterion("command_str <>", value, "commandStr");
            return (Criteria) this;
        }

        public Criteria andCommandStrGreaterThan(String value) {
            addCriterion("command_str >", value, "commandStr");
            return (Criteria) this;
        }

        public Criteria andCommandStrGreaterThanOrEqualTo(String value) {
            addCriterion("command_str >=", value, "commandStr");
            return (Criteria) this;
        }

        public Criteria andCommandStrLessThan(String value) {
            addCriterion("command_str <", value, "commandStr");
            return (Criteria) this;
        }

        public Criteria andCommandStrLessThanOrEqualTo(String value) {
            addCriterion("command_str <=", value, "commandStr");
            return (Criteria) this;
        }

        public Criteria andCommandStrLike(String value) {
            addCriterion("command_str like", value, "commandStr");
            return (Criteria) this;
        }

        public Criteria andCommandStrNotLike(String value) {
            addCriterion("command_str not like", value, "commandStr");
            return (Criteria) this;
        }

        public Criteria andCommandStrIn(List<String> values) {
            addCriterion("command_str in", values, "commandStr");
            return (Criteria) this;
        }

        public Criteria andCommandStrNotIn(List<String> values) {
            addCriterion("command_str not in", values, "commandStr");
            return (Criteria) this;
        }

        public Criteria andCommandStrBetween(String value1, String value2) {
            addCriterion("command_str between", value1, value2, "commandStr");
            return (Criteria) this;
        }

        public Criteria andCommandStrNotBetween(String value1, String value2) {
            addCriterion("command_str not between", value1, value2, "commandStr");
            return (Criteria) this;
        }

        public Criteria andReplyStrIsNull() {
            addCriterion("reply_str is null");
            return (Criteria) this;
        }

        public Criteria andReplyStrIsNotNull() {
            addCriterion("reply_str is not null");
            return (Criteria) this;
        }

        public Criteria andReplyStrEqualTo(String value) {
            addCriterion("reply_str =", value, "replyStr");
            return (Criteria) this;
        }

        public Criteria andReplyStrNotEqualTo(String value) {
            addCriterion("reply_str <>", value, "replyStr");
            return (Criteria) this;
        }

        public Criteria andReplyStrGreaterThan(String value) {
            addCriterion("reply_str >", value, "replyStr");
            return (Criteria) this;
        }

        public Criteria andReplyStrGreaterThanOrEqualTo(String value) {
            addCriterion("reply_str >=", value, "replyStr");
            return (Criteria) this;
        }

        public Criteria andReplyStrLessThan(String value) {
            addCriterion("reply_str <", value, "replyStr");
            return (Criteria) this;
        }

        public Criteria andReplyStrLessThanOrEqualTo(String value) {
            addCriterion("reply_str <=", value, "replyStr");
            return (Criteria) this;
        }

        public Criteria andReplyStrLike(String value) {
            addCriterion("reply_str like", value, "replyStr");
            return (Criteria) this;
        }

        public Criteria andReplyStrNotLike(String value) {
            addCriterion("reply_str not like", value, "replyStr");
            return (Criteria) this;
        }

        public Criteria andReplyStrIn(List<String> values) {
            addCriterion("reply_str in", values, "replyStr");
            return (Criteria) this;
        }

        public Criteria andReplyStrNotIn(List<String> values) {
            addCriterion("reply_str not in", values, "replyStr");
            return (Criteria) this;
        }

        public Criteria andReplyStrBetween(String value1, String value2) {
            addCriterion("reply_str between", value1, value2, "replyStr");
            return (Criteria) this;
        }

        public Criteria andReplyStrNotBetween(String value1, String value2) {
            addCriterion("reply_str not between", value1, value2, "replyStr");
            return (Criteria) this;
        }

        public Criteria andCreateQidIsNull() {
            addCriterion("create_qid is null");
            return (Criteria) this;
        }

        public Criteria andCreateQidIsNotNull() {
            addCriterion("create_qid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateQidEqualTo(Long value) {
            addCriterion("create_qid =", value, "createQid");
            return (Criteria) this;
        }

        public Criteria andCreateQidNotEqualTo(Long value) {
            addCriterion("create_qid <>", value, "createQid");
            return (Criteria) this;
        }

        public Criteria andCreateQidGreaterThan(Long value) {
            addCriterion("create_qid >", value, "createQid");
            return (Criteria) this;
        }

        public Criteria andCreateQidGreaterThanOrEqualTo(Long value) {
            addCriterion("create_qid >=", value, "createQid");
            return (Criteria) this;
        }

        public Criteria andCreateQidLessThan(Long value) {
            addCriterion("create_qid <", value, "createQid");
            return (Criteria) this;
        }

        public Criteria andCreateQidLessThanOrEqualTo(Long value) {
            addCriterion("create_qid <=", value, "createQid");
            return (Criteria) this;
        }

        public Criteria andCreateQidIn(List<Long> values) {
            addCriterion("create_qid in", values, "createQid");
            return (Criteria) this;
        }

        public Criteria andCreateQidNotIn(List<Long> values) {
            addCriterion("create_qid not in", values, "createQid");
            return (Criteria) this;
        }

        public Criteria andCreateQidBetween(Long value1, Long value2) {
            addCriterion("create_qid between", value1, value2, "createQid");
            return (Criteria) this;
        }

        public Criteria andCreateQidNotBetween(Long value1, Long value2) {
            addCriterion("create_qid not between", value1, value2, "createQid");
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