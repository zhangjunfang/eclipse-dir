 namespace java com.javabloger.gen.code   # 注释1   定义生成代码的命名空间，与你需要定义的package相对应。

        struct Blog {   #  注释2.1   定义实体名称和数据结构，类似你业务逻辑中的pojo get/set
            1: string topic     #  注释2.2  参数类型可以参见 Thrift wiki
            2: binary content
            3: i64    createdTime
            4: string id
            5: string ipAddress
            6: map<string,string> props
          }
        service ThriftCase {  #  注释3    代码生成的类名，你的业务逻辑代码需要实现代码生成的ThriftCase.Iface接口
            i32 testCase1(1:i32 num1, 2:i32 num2, 3:string  num3) #注释4.1 方法名称和方法中的入参，入参类型参见wiki
            list<string> testCase2(1:map<string,string>  num1)
            void testCase3()
            void testCase4(1:list<Blog> blog)   #  注释4.2   list 是thrift中基本数据类型中的一种，list中包含的Blog对象是上面struct中定义的
        }