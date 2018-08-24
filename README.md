# hibernate-1
本例子中由后台完成的session创建的过程=======
Configuration conf = new Configuration();
conf.configure()//这个是自动扫描src下面的hibernate.cfg.xml文件或者可以自己指定扫描目录
SessionFactory sf = conf.buildSessionFactory();//用于创建操作数据库session对象的工厂
Session session = sf.openSession();//打开一个新session，hibernate与数据库之间的操作由session完成
//sf.getCurrentSession();获得一个与线程绑定的session对象，同一个
Transaction transaction = session.beginTransaction();//创建事务并开启
//transaction = session.getTransanction()//开启事务
Student s = new Stident(null,"","");
session.save(s);//执行保存
transaction.commit();
session.close();
sessionFactory.close();
