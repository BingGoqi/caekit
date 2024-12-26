# 项目转至隔壁 kaktus

## 超越STK（11)

来自ksp玩家

| 数字 | 0.0 | 0.3 | 0.6 | 0.9 | 1.0 |
| ------- | ------- | ------- | ------- | ------- | ------- |
| 进度 | 计划阶段 | 数学阶段 | 设计阶段 | 编码阶段 | 测试阶段 |

## caekit

- animtion 0.8
	- 区间
	- 节点
	- 事件
	- 状态机
- craft
	- resource资源管理 0.8
	- 物理结构
	- 组件结构
	- 渲染结构
	- 飞行状态
- Mash 网络
- space 空间
	- Body 星体 0.5
	-  Orbiter 轨道 0.6
	- Forces 力模型 0.4
	- Frame 坐标系 0.8
- 近景物理计算
	- 刚体 0.6
	- 刚体柔性连接 0.7
	- 弹性体 0.2
- Math 数学
	- 常用非线性方程 0.5
	- 常用特殊函数
- 文件管理
- orekit
- gpu
- 网络连接

Spase:

Body
- System 星系*
- 几何形状（math.geometric 中）*
    - Sphere 球体 0.7
    - OblateSp 单椭球 0.7
    - ProlateSp 双椭球
- Ring 星环 0.2

Orbit
- HermitePV 三阶星历（math.interpolation中）* 0.7
- HermitePVA 五阶星历(同上*
- Kepler*
    - Battin 普适方程 0.8
    - 拼接圆锥曲线 0.3
    - 多圆锥曲线法 0.4
- H-W 轨道
- Encke 轨道
- SST 轨道 0.2
- 笛卡尔轨道
    - RK45（在math.integrate中) 0.5
    - RK78 (同上 0.5
    - RKF853 (同上 0.5
- T-H轨道
- C-W轨道 0.3
- KPrecession 进动椭圆
- KLDrift 长周期飘移* 0.6
Frame
- 惯性 0.8
- 非惯性 0.2

## ctkit(暂定)

- gis 地形相关工具
- preprocessor 文件预处理
- simple opengl 封装
- tree 组织树处理
