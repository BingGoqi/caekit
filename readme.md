# 超越STK（11)

来自ksp玩家

## caekit
- animtion
	- 区间
	- 节点
	- 事件
	- 状态机
- craft
	- resource资源管理
	- 物理结构
	- 组件结构
	- 渲染结构
	- 飞行状态
- Mash 网络
- space 空间
	- Body 星体
	-  Orbiter 轨道
	- Forces 力模型
	- Frame 坐标系
- 近景物理计算
- Math 数学
- 文件管理
- orekit
- gpu
- 网络连接

Spase:

Body
- System 星系*
- 几何形状（math.geometric 中）*
    - Sphere 球体
    - OblateSp 单椭球
    - ProlateSp 双椭球
- Ring 星环

Orbit
- HermitePV 三阶星历（math.interpolation中）*
- HermitePVA 五阶星历(同上*
- Kepler*
    - Battin 普适方程
    - 拼接圆锥曲线
    - 多圆锥曲线法
- H-W 轨道
- Encke 轨道
- SST 轨道
- 笛卡尔轨道
    - RK45（在math.integrate中)
    - RK78 (同上
    - RKF853 (同上
- T-H轨道
- C-W轨道
- KPrecession 进动椭圆
- KLDrift 长周期飘移*
Frame
- 惯性
- 非惯性
