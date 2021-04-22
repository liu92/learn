package org.learn.boot.task.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * @ClassName: MyTriggerListener
 * @Description:
 * @Author: lin
 * @Date: 2020/8/11 14:36
 * History:
 * @<version> 1.0
 */
public class MyTriggerListener implements TriggerListener {

    @Override
    public String getName() {
        String name = this.getClass().getSimpleName();
        System.out.println("触发器的名称：" + name );
        return null;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        String name = trigger.getKey().getName();
        System.out.println(name + "被触发");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        String name = trigger.getKey().getName();
        //TriggerListener 给一个选择去否决Job的执行。假如这个方法返回true，这个job将不会为此次Trigger触发而得到执行。
        System.out.println(name + " 没有被触发");
        //true:表示不好执行Job的方法。
        return true;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        String name = trigger.getKey().getName();
        //Scheduler 调用这个方法是在Trigger 错过触发时
        System.out.println(name + " 错过触发");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        String name = trigger.getKey().getName();
        //trigger 被触发并且完成了Job的执行时，Scheduler调用这个方法。
        System.out.println(name + " 完成之后触发");
    }
}
