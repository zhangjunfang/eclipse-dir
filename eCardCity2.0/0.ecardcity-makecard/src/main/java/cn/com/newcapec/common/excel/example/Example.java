package cn.com.newcapec.common.excel.example;

import cn.com.newcapec.common.excel.entity.IBaseExcel;
import cn.com.newcapec.common.excel.util.DateHelper;

import java.util.Date;

/**
 * <p>
 * 功能描述:EXCEL例子
 *   
 * Author : Wangjian 
 * Date   : 2007-11-14
 * Time   : 13:25:22
 * Version: 1.2
 * </p>
 */
public class Example implements IBaseExcel
{
	private Double id;      //编号
    private String name;    //姓名
    private Double age;     //年龄
    private Date birthday;  //出生日期
    private Double salary;  //薪水
    private Double bonus;   //奖金
    private Date statDate;  //统计时间
    private String remark;  //备注
    
    private String sheetName;//工作表名称
    
    private String errorPrompt;//错误提示信息
    
    public Example()
    {
    }

    public Double getId()
    {
        return id;
    }

    public void setId(Double id)
    {
        this.id = id;
    }

    public Double getAge()
    {
        return age;
    }

    public void setAge(Double age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public Double getSalary()
    {
        return salary;
    }

    public void setSalary(Double salary)
    {
        this.salary = salary;
    }

    public Double getBonus()
    {
        return bonus;
    }

    public void setBonus(Double bonus)
    {
        this.bonus = bonus;
    }

    public Date getStatDate()
    {
        return statDate;
    }

    public void setStatDate(Date statDate)
    {
        this.statDate = statDate;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    
    public void setSheetName(String sheetName)
    {
        this.sheetName=sheetName;
    }

    public String getSheetName()
    {
        return this.sheetName;
    }

    public boolean isAllFieldNull()
    {
        return (name == null || name.length() == 0) && age == null
               && birthday == null && salary == null && bonus == null 
               && statDate == null && (remark == null || remark.length() == 0);
    }

    public boolean validate()
    {
        boolean flag = true;
        StringBuffer errorMSG = new StringBuffer();
        if (name == null)
        {
            flag = false;
            errorMSG.append("\n姓名不能为空");
        }
        if (age == null)
        {
            flag = false;
            errorMSG.append("\n年龄不能为空");
        }
        if (birthday == null)
        {
            flag = false;
            errorMSG.append("\n出生日期不能为空");
        }
        if (!flag)
        {
            errorPrompt = "错误提示：" + errorMSG.toString();
        }
        return flag;
    }

    public String toString()
    {
        return new StringBuffer()
                .append(("\n\n\n\n工作表:" + sheetName))
                .append(("\n\n编号:" + id))
                .append(("\n姓名:" + name))
                .append(("\n年龄:" + age))
                .append(("\n出生日期:" + DateHelper.formatDate(birthday, DateHelper.SHORT_DATE_FORMAT)))
                .append(("\n薪水:" + salary))
                .append(("\n奖金:" + bonus))
                .append(("\n统计时间:" + DateHelper.formatDate(statDate, DateHelper.MIDDLE_DATE_FORMAT)))  
                .append(("\n备注:" + remark)).toString();
    }

	public String getErrorPrompt()
	{
		return errorPrompt;
	}
}
