package com.rapdog.rapbot.bean.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class McGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public McGoodsExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIsNull() {
            addCriterion("goods_desc is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIsNotNull() {
            addCriterion("goods_desc is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescEqualTo(String value) {
            addCriterion("goods_desc =", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotEqualTo(String value) {
            addCriterion("goods_desc <>", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescGreaterThan(String value) {
            addCriterion("goods_desc >", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescGreaterThanOrEqualTo(String value) {
            addCriterion("goods_desc >=", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLessThan(String value) {
            addCriterion("goods_desc <", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLessThanOrEqualTo(String value) {
            addCriterion("goods_desc <=", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLike(String value) {
            addCriterion("goods_desc like", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotLike(String value) {
            addCriterion("goods_desc not like", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIn(List<String> values) {
            addCriterion("goods_desc in", values, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotIn(List<String> values) {
            addCriterion("goods_desc not in", values, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescBetween(String value1, String value2) {
            addCriterion("goods_desc between", value1, value2, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotBetween(String value1, String value2) {
            addCriterion("goods_desc not between", value1, value2, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameIsNull() {
            addCriterion("goods_class_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameIsNotNull() {
            addCriterion("goods_class_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameEqualTo(String value) {
            addCriterion("goods_class_name =", value, "goodsClassName");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameNotEqualTo(String value) {
            addCriterion("goods_class_name <>", value, "goodsClassName");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameGreaterThan(String value) {
            addCriterion("goods_class_name >", value, "goodsClassName");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_class_name >=", value, "goodsClassName");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameLessThan(String value) {
            addCriterion("goods_class_name <", value, "goodsClassName");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameLessThanOrEqualTo(String value) {
            addCriterion("goods_class_name <=", value, "goodsClassName");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameLike(String value) {
            addCriterion("goods_class_name like", value, "goodsClassName");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameNotLike(String value) {
            addCriterion("goods_class_name not like", value, "goodsClassName");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameIn(List<String> values) {
            addCriterion("goods_class_name in", values, "goodsClassName");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameNotIn(List<String> values) {
            addCriterion("goods_class_name not in", values, "goodsClassName");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameBetween(String value1, String value2) {
            addCriterion("goods_class_name between", value1, value2, "goodsClassName");
            return (Criteria) this;
        }

        public Criteria andGoodsClassNameNotBetween(String value1, String value2) {
            addCriterion("goods_class_name not between", value1, value2, "goodsClassName");
            return (Criteria) this;
        }

        public Criteria andGoodsInventoryIsNull() {
            addCriterion("goods_inventory is null");
            return (Criteria) this;
        }

        public Criteria andGoodsInventoryIsNotNull() {
            addCriterion("goods_inventory is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsInventoryEqualTo(Integer value) {
            addCriterion("goods_inventory =", value, "goodsInventory");
            return (Criteria) this;
        }

        public Criteria andGoodsInventoryNotEqualTo(Integer value) {
            addCriterion("goods_inventory <>", value, "goodsInventory");
            return (Criteria) this;
        }

        public Criteria andGoodsInventoryGreaterThan(Integer value) {
            addCriterion("goods_inventory >", value, "goodsInventory");
            return (Criteria) this;
        }

        public Criteria andGoodsInventoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_inventory >=", value, "goodsInventory");
            return (Criteria) this;
        }

        public Criteria andGoodsInventoryLessThan(Integer value) {
            addCriterion("goods_inventory <", value, "goodsInventory");
            return (Criteria) this;
        }

        public Criteria andGoodsInventoryLessThanOrEqualTo(Integer value) {
            addCriterion("goods_inventory <=", value, "goodsInventory");
            return (Criteria) this;
        }

        public Criteria andGoodsInventoryIn(List<Integer> values) {
            addCriterion("goods_inventory in", values, "goodsInventory");
            return (Criteria) this;
        }

        public Criteria andGoodsInventoryNotIn(List<Integer> values) {
            addCriterion("goods_inventory not in", values, "goodsInventory");
            return (Criteria) this;
        }

        public Criteria andGoodsInventoryBetween(Integer value1, Integer value2) {
            addCriterion("goods_inventory between", value1, value2, "goodsInventory");
            return (Criteria) this;
        }

        public Criteria andGoodsInventoryNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_inventory not between", value1, value2, "goodsInventory");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(Float value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(Float value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(Float value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(Float value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(Float value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<Float> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<Float> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(Float value1, Float value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(Float value1, Float value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
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