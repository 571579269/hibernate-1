# hibernate-1
本例子中由后台完成的session创建的过程
Configuration conf = new Configuration();
conf.configure()//这个是自动扫描src下面的hibernate.cfg.xml文件或者可以自己指定扫描目录
SessionFactory sf = conf.buildSessionFactory();//用于创建操作数据库session对象的工厂
Session session = sf.openSession();//创建session
Transaction transaction = session.beginTransaction();//创建事务饼开启
Student s = new Stident(null,"","");
session.save(s);//执行保存
transaction.commit();
session.close();
sessionFactory.close();
