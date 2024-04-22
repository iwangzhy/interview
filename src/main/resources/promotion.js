// 定义价格
const prices = {
  "大碗牛肉面": 18,
  "中碗牛肉面": 16,
  "小碗牛肉面": 14,
  "大碗肥肠面": 20,
  "中碗肥肠面": 18,
  "小碗肥肠面": 16,
  "牛肉饼": 10,
  "奶茶": 12,
  "套餐1":38,
  "套餐2":40,
};

const combos = {
  "套餐1": {"大碗牛肉面": 1, "牛肉饼": 1, "奶茶": 1},
  "套餐2": {"大碗肥肠面": 1, "牛肉饼": 1, "奶茶": 1}
};

/**
 * 计算费用
 * @param items 菜品数组,例如：["大碗牛肉面","中碗牛肉面"]
 * @returns {number}
 */
function calculatePayment(items) {
  if (!items) {
    alert("请输入菜品");
  }
  // 统计每个产品的数量
  let itemCounts = {};
  items.forEach(item => {
    itemCounts[item] = (itemCounts[item] || 0) + 1;
  });
  let totalCost = 0;
  // 尝试匹配套餐
  // 套餐-套餐商品
  for (const [combo, components] of Object.entries(combos)) {

    let comboCount = Infinity;
    // 计算套餐次数
    for (const [component, required] of Object.entries(components)) {
      comboCount = Math.min(comboCount, Math.floor((itemCounts[component] || 0) / required));
    }

    // 如果可以应用套餐，则减去相应的数量并增加套餐价格
    if (comboCount > 0) {
      Object.entries(components).forEach(([component, required]) => {
        itemCounts[component] -= required * comboCount;
      });
      totalCost += prices[combo] * comboCount;
    }
  }

  // 加上剩余单品的费用
  Object.entries(itemCounts).forEach(([item, count]) => {
    if (count > 0) totalCost += (prices[item] || 0) * count;
  });

  return totalCost;
}

// 费用
let zhangsan = calculatePayment(["套餐1","牛肉饼"]); // 48
let lisi = calculatePayment(["中碗肥肠面", "奶茶", "奶茶"]); // 42
let wangwu = calculatePayment(["大碗肥肠面", "牛肉饼", "奶茶"]); // 40 套餐2

console.log("张三应付：" + zhangsan);
console.log("李四应付：" + lisi);
console.log("王五应付：" + wangwu);