第一章
-----------------
  主要讲解深度、广度优先搜索模版，深度优先搜索可以通过栈以及递归来实现，广度优先搜索通过队列的方式进行实现
  将每一层的需要遍历的对象放置到队列中，如同水波扩散一样进行遍历，下图为本章脑图集锦：
![image](https://github.com/DoddyApe-loveCat/-algorithm015/blob/master/images/recursion.png)

第二章
-----------------
  本章主要讲述贪心算法的使用，他是在每一步选择中都采取当前状态最好或者最优的选择，从而希望导致结果是全局最好或者最优
  的算法；
  适用贪心算法的场景：简单说问题能够分解成子问题来解决，子问题的最优解能够递推到最终问题的最优解，这种子问题的最优解称为
  最优子结构；
  贪心算法与动态规划的不同在于它对每个子问题的解决方案都作出选择不能回退，动态规划会保存以前的结果，并根据以前的结果对
  当前进行选择有回退功能️，下图为本章贪心算法题集脑图
![image](https://github.com/DoddyApe-loveCat/-algorithm015/blob/master/images/cutBranch.png)

第三章
-----------------
  本章主要讲述二分查找的思路，下为二分查找的模版
   ```java
    int left = 0, right = array.length - 1;
    while (left < right) {
        int mid = (left + right) / 2;
        if (array[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }          
    }   
   ```
   使用二分查找的前提：
   1.目标函数单调性（单调递增或者单调递减）
   2.存在上下界
   3.能够通过索引访问
![image](https://github.com/DoddyApe-loveCat/-algorithm015/blob/master/images/cutBranch.png)
