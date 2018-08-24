# hibernate-1
##本例子中由后台完成的session创建的过程
```Java
    Configuration conf = new Configuration();
    conf.configure()//这个是自动扫描src下面的hibernate.cfg.xml文件或者可以自己指定扫描目录
    SessionFactory sf = conf.buildSessionFactory();//用于创建操作数据库session对象的工厂
    Session session = sf.openSession();//打开一个新session，hibernate与数据库之间的操作由session完成
    //sf.getCurrentSession();获得一个与线程绑定的session对象，同一个
    Transaction transaction = session.beginTransaction();//创建事务并开启
    //transaction = session.getTransanction()//开启事务
    Student s = new Student(null,"","");
    //=============CRUD============
    session.save(s);//执行保存
    session.get(Student.class,1);//第一个参数是找的类型，第二个参数是查询的id
    //修改步骤 1、获得要修改的对象  2、修改   3、执行update
    Student s = session.get(Student.class,1);
    s.setName("aa")
    session.update(s);
    //删除步骤 1、先获取 2、删除
    Student s = session.get(Student.class,1);
    session.delete(s);
    //=========================
    transaction.commit();
    //transaction.rollback();事务回滚
    session.close();
    sessionFactory.close();
```
##一些知识点

    generator:主键生成策略：每条记录录入时，主键的生成规则
        identity:主键自增<generator class="identity"/>
        uuid：产生随机字符串作为主键
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO. 
	TABLE：使用一个特定的数据库表格来保存主键。 
	SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。 
	IDENTITY：主键由数据库自动生成（主要是自动增长型） 
	AUTO：主键由程序控制。
	
    Query使用步骤：
    =====
    1、获取hibernate的session对象
    2、编写HQL语句
    3、调用session.createQuery创建查询对象
    4、如果HQL语句包含参数，则调用Query的setXxx设置参数
    5、调用Query对象的list()或uniqueResult()方法执行查询
    	uniqueResult()方法，用于返回唯一的结果，只有在确保只有一条记录时使用
    
```Java
    //查询所有记录
    Query query = session.createQuery("from Student");
    List<Student> list = query.list();
    System.out.println(list);
    //条件查询
    Query query = session.createQuery("from Student where name=?");//问号占位符
    query.setString(0,"张三");
    List<Student> list = query.list();
    System.out.println(list);
    
    Query query = session.createQuery("from Student where name=:aaa and age=:bbb");//命名占位符
    query.setString("aaa","张三");
    query.setString("bbb",38);
    List<Student> list = query.list();
    System.out.println(list);
    
    //分页查询
    Query query = session.createQuery("from Student");
    query.setFirstResult(3);//设置获取第一个记录的位置，表示从第几条记录开始查询，默认从0
    query.setMaxResult(3);//设置结果集中的最大记录数，
    List<Student> list = query.list();
    System.out.println(list);
```
    Criteria--核心查询对象
    ====
    使用步骤：
    1、获得hibernate的Session对象
    2、通过Session获得Criteria对象
    3、使用Restrictions的静态方法创建Criterion条件对象。Restrictions类中提供了一系列用于设定查询条件的静态方法，这些静态方法都返回Criterion实例
    每个Criterion实例代表一个查询条件
    4、想Criteria对象中添加Criterion查询条件，Criteria的add()方法用于加入查询条件
    5、执行Criteria的list()或uniqueResult()获得结果
```Java
    //查询所有记录
    Criteria criteria = session.createCriteria(Student.class);
    List<Student> list = criteria.list();
    System.out.println(list);
    
    //条件查询
    Criteria criteria = session.createCriteria(Student.class);
    criteria.add(Restriction.eq("name","李健"));
    List<Student> list = criteria.list();
    System.out.println(list);
    
    Criteria criteria = session.createCriteria(Student.class);
    criteria.add(Restriction.eq("name","李健"));
    criteria.add(Restriction.eq("age","38"));
    List<Student> list = criteria.list();
    System.out.println(list);
    
    //分页查询
    Criteria criteria = session.createCriteria(Student.class);
    criteria.setFirstResult(3);//设置获取第一个记录的位置，表示从第几条记录开始查询，默认从0
    criteria.setMaxResult(3);//设置结果集中的最大记录数，
    List<Student> list = criteria.list();
    System.out.println(list);
```
    SQLQuery 语句  直接使用sql查询语句
    SQLQuery sqlQuery = session.createSQLQuery("select * from Student_t");
    List<Object[]> list = sqlQuery.list();
    for(Object[] objects : list){
    System.out.println(Arrays.toString(objects));
    }
