# Graph Connectivity Algorithms

## Spanning trees
- A spanning tree of an arbitrary graph is a subgraph (tree) from a given root that includes paths to each reachable node. Another term for this is a **single-source reachability** problem.
![image](https://user-images.githubusercontent.com/66233296/164995015-66cdd3bb-408b-466e-be42-c7e933208b26.png)

### A spanning tree for X vertices will have X-1 edges.
![image](https://user-images.githubusercontent.com/66233296/164995477-3768ed9a-7eb5-4c89-9c0b-a3ad320007ec.png)
![image](https://user-images.githubusercontent.com/66233296/164995499-79376293-a1c2-45e4-abf1-9c3c894e4eaa.png)

### Properties 
![image](https://user-images.githubusercontent.com/66233296/164995722-3dd0dfe4-af1c-434a-be49-fda80987bdeb.png)


## Union Find

![image](https://user-images.githubusercontent.com/66233296/164998457-03800313-9f2a-427c-9f43-196d255382b6.png)

### Find()
- Set representative so the find(x) method will only return representative
- This way it can check if the two elements are in the same group or not (find(x) = find(y) = representative
![image](https://user-images.githubusercontent.com/66233296/164998478-db9adc7a-bd43-4a78-bd1f-487ed76a9e64.png)
![image](https://user-images.githubusercontent.com/66233296/164998544-7071c35a-2e66-4c27-8689-32259d0410e4.png)

### Union()
![image](https://user-images.githubusercontent.com/66233296/164998588-8fb629c5-fd20-4746-87c9-479e43cb8875.png)


### Implemenation 
![image](https://user-images.githubusercontent.com/66233296/164998639-ac7b0186-220b-4f87-8dee-972a28d77d0a.png)

