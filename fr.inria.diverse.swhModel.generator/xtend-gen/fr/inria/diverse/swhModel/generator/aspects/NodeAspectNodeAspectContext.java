package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.Node;
import java.util.Map;

@SuppressWarnings("all")
public class NodeAspectNodeAspectContext {
  public static final NodeAspectNodeAspectContext INSTANCE = new NodeAspectNodeAspectContext();
  
  public static NodeAspectNodeAspectProperties getSelf(final Node _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.NodeAspectNodeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Node, NodeAspectNodeAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.Node, fr.inria.diverse.swhModel.generator.aspects.NodeAspectNodeAspectProperties>();
  
  public Map<Node, NodeAspectNodeAspectProperties> getMap() {
    return map;
  }
}
