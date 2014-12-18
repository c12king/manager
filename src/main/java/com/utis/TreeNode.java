package com.utis;
import java.util.ArrayList;

import net.sf.json.JSONObject;
public class TreeNode {
	private String id;
	private String pid; 
	private String text; 
	private String remark;
	private String state;
	private String attributes ;
	
	private ArrayList<TreeNode> children = new ArrayList<TreeNode>();
	public TreeNode(String id, String pid, String text, String remark,int state) { 
		this.id = id;   
		this.pid = pid;   
		this.text = text;   
		this.remark = remark;   
		if(state==1){
			this.state="closed";
		}else if(state==0){
			this.state="open";
		}
	}
	
	public TreeNode(String id, String pid, String text, String remark,int state,String type) { 
		this.id = id;   
		this.pid = pid;   
		this.text = text;   
		this.remark = remark;   
		if(state==1){
			this.state="closed";
		}else if(state==0){
			this.state="open";
		}
		JSONObject json =new JSONObject();
		json.put("type", type);
		this.attributes=json.toString();
	}
	
	public void add(TreeNode node) {
		//�ݹ���ӽڵ�   
		if ("0".equals(node.pid)) { 
			this.children.add(node);
		} else if (node.pid.equals(this.id)) {
			this.children.add(node); 
		} else {
			for (TreeNode tmp_node : children) {
				tmp_node.add(node);
			}
		}
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getText() {
		return text;
	}
	public void setText(String Text) {
		this.text = Text;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ArrayList<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<TreeNode> children) {
		this.children = children;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	
}
