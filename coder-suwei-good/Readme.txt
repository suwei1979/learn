1.  应用场景
    列表查询功能开发框架
2.  解决的问题：
	简化应用开发过程中的列表查询开发工作，使开发此功能的人在最简单情况下
	只需要定义接口对象、领域对象，以及sql语句，就可以实现分页列表查询功能
	具体场景可参考测试文件夹下的：
	com.baidu.rigel.service.industry.IndustryServiceTest
	com.baidu.rigel.repository.mybatis.PagingRepositoryProxyTest
   
3.  运行要求：
    1) 已安装Lombok（如未安装参考下列步骤）：
    	i	关闭eclipse
    	ii	下载lombok.jar[https://projectlombok.org/]
    	iii  run java -jar lombok.jar, and follow instructions.
    2) 本机已安装mysql server并且已创建名为test的数据库	
    3) 从svn导入此Maven项目
    
4. 运行说明：
	1) mvn test
	2) 也可以在eclipse中，选择任意一个单独的测试案例进行运行测试

5. 目录结构
|-src
 |---main 本次申请评审内容
 |-----java
 |-------com
 |---------baidu
 |-----------rigel
 |-------------domain 基础领域对象包，包括用于封装分页查询请求的基础对象
 |---------------support 目前仅一个类，PagedListHelper，用于转换PagedList
 |-------------repository Repository公共接口
 |---------------mybatis 基于Mybatis的PagingRepository实现
 |-------------util  工具类
 |-----resources
 |---test
 |-----java
 |-------com
 |---------baidu
 |-----------rigel
 |-------------domain
 |---------------industry
 |-------------repository
 |---------------mybatis
 |-------------service
 |---------------industry
 |-----------------dto
 |-----------------impl
 |-------------util
 |-----resources
 |-------com
 |---------baidu
 |-----------rigel
 |-------------account
 |---------------mapper
 |-------------industry
 |---------------mapper
 |-------conf
 |-------dozer
 |-------prop
 |-------script	