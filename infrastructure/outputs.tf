output "cluster_name" {
  value = kind_cluster.fibonacci.name
}

output "kubectl_context" {
  value = "kind-${var.cluster_name}"
}

output "application_url" {
  value = "http://localhost:${var.host_port}"
}